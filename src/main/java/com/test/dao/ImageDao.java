package com.test.dao;

import com.test.entity.Images;
import org.springframework.stereotype.Repository;


/**
 * Created by yyb on 2017/8/29 0029.
 */
@Repository
public interface ImageDao {
    void saveImage(Images img);
}
