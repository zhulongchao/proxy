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
public interface CrudService {

    Long create(String content);

    List<String> retrieve(String condition);

    boolean update(Long id, String content);

    boolean delete(Long id);
}
