package com.techelevator.controller;
import com.techelevator.dao.ImagesDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Image;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/images")
public class ImagesController {
    private final ImagesDao dao;
    private final UserDao userDao;
    public ImagesController(ImagesDao dao, UserDao userDao) {
        this.dao = dao;
        this.userDao = userDao;
    }

    @PostMapping(path = "")
    public ResponseEntity<byte[]> saveImage(@RequestPart("data") MultipartFile file,
                                            UriComponentsBuilder uriBuilder, Principal principal) throws IOException {

        Image newImage = new Image(file.getBytes(), file.getContentType());
        newImage = dao.save(newImage, userDao.getUserByUsername(principal.getName()).getId());

        // create the URI that will be used in the Location header for the 201 Created response
        URI selfLink = MvcUriComponentsBuilder.relativeTo(uriBuilder)
                .withMethodName(this.getClass(), "getImage", newImage.getId())
                .build().toUri();

        return ResponseEntity.created(selfLink).build();
    }

    @GetMapping(path = "/{id}", name = "getImage")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        Image image = dao.getById(id);
        if (null == image) return ResponseEntity.notFound().build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("content-length", Integer.toString(image.getData().length))
                .header("content-type", image.getMediatype())
                .body(image.getData());
    }

    @GetMapping(path = "/imageids", name = "getImageIds")
    public List<Integer> getImageIds(Principal principal) {
        List<Integer> imageIds = dao.getImageIdsForUser(userDao.getUserByUsername(principal.getName()).getId());
        return imageIds;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> replaceImage(@PathVariable int id, @RequestPart("data") MultipartFile file, Principal principal) throws IOException {
        if (!dao.exists(id)) return ResponseEntity.notFound().build();

        final Image image = new Image(id, file.getBytes(), file.getContentType());
        dao.save(image,  userDao.getUserByUsername(principal.getName()).getId());

        return ResponseEntity.noContent().build();
    }
}


