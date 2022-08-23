package com.yamy.shop.admin.controller;

import com.yamy.shop.common.bean.Qiniu;
import com.yamy.shop.service.AttachFileService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 程祥
 * @date 2022/8/22 19:45
 */
@RestController
@RequestMapping("/admin/file")
@CrossOrigin
public class FileController {
    @Autowired
    private AttachFileService attachFileService;

    @Autowired
    private Qiniu qiniu;

    @PostMapping("/upload/element")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if(file.isEmpty()) {
            // 204 NO_CONTENT
            return ResponseEntity.noContent().build();
        }
        String filePath = attachFileService.uploadFile(file.getBytes(), file.getOriginalFilename());
        return ResponseEntity.ok(filePath);
    }

    @PostMapping("/dupload/tinymceEditor")
    public ResponseEntity<String> uploadTinymceEditorImages(@RequestParam("editorFile") MultipartFile editorFile) throws IOException {
        String fileName =  attachFileService.uploadFile(editorFile.getBytes(),editorFile.getOriginalFilename());
        return ResponseEntity.ok(qiniu.getResourcesUrl() + fileName);
    }
}
