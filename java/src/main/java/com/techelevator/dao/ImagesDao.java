package com.techelevator.dao;


import com.techelevator.model.Image;

import java.util.List;

public interface ImagesDao {

    Image getById(int id);
    Image save(Image image,int userId);
    boolean exists(int id);
    List<Integer> getImageIdsForUser(int userid);
}
