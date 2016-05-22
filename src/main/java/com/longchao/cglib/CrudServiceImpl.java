package com.longchao.cglib;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author chuan.qing(zhu.longchao)
 * @version 1.0
 * @create 2016/5/19.
 */
public class CrudServiceImpl implements CrudService {
    @Override
    public Long create(String content) {
        System.out.println("create......");
        return 1L;
    }

    @Override
    public List<String> retrieve(String condition) {
        System.out.println("retrieve......");
        return null;
    }

    @Override
    public boolean update(Long id, String content) {
        System.out.println("update......");
        return true;
    }

    @Override
    public boolean delete(Long id) {
        System.out.println("delete......");
        return false;
    }
}
