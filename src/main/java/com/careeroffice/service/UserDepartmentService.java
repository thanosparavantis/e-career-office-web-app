package com.careeroffice.service;

import com.careeroffice.dao.DepartmentDao;
import com.careeroffice.dao.factory.DaoEnum;
import com.careeroffice.dao.factory.DaoFactory;
import com.careeroffice.dao.pivot.UserDepartmentDao;
import com.careeroffice.model.UserDepartment;

import java.util.List;

public class UserDepartmentService implements IPersistenceService<UserDepartment> {

    private UserDepartmentDao userDepartmentDao = (UserDepartmentDao) DaoFactory.getDao(DaoEnum.UserDepartmentDao);
    private DepartmentDao departmentDao = (DepartmentDao) DaoFactory.getDao(DaoEnum.DepartmentDao);

    private void setupRelationships(UserDepartment userDepartment) {
        userDepartment.setDepartment(departmentDao.findOne(userDepartment.getDepartmentId()));
    }

    public UserDepartment findOne(String id) {
        UserDepartment userDepartment = userDepartmentDao.findOne(id);

        setupRelationships(userDepartment);

        return userDepartment;
    }

    public List<UserDepartment> findAll() {
        List<UserDepartment> userDepartments = userDepartmentDao.findAll();

        userDepartments.forEach(this::setupRelationships);

        return userDepartments;
    }

    public UserDepartment save(UserDepartment obj) {
        return userDepartmentDao.save(obj);
    }

    public UserDepartment update(UserDepartment obj) {
        return userDepartmentDao.update(obj);
    }

    public boolean delete(String id) {
        return userDepartmentDao.delete(id);
    }

    public int count() {
        return userDepartmentDao.count();
    }
}
