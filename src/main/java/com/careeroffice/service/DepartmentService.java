package com.careeroffice.service;

import com.careeroffice.dao.DepartmentDao;
import com.careeroffice.dao.factory.DaoEnum;
import com.careeroffice.dao.factory.DaoFactory;
import com.careeroffice.model.Department;

public class DepartmentService implements IPersistenceService<Department> {

    private DepartmentDao departmentDao = (DepartmentDao) DaoFactory.getDao(DaoEnum.DepartmentDao);

    public Department findOne(String id) {
        return departmentDao.findOne(id);
    }
}