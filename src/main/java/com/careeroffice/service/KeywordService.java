package com.careeroffice.service;

import com.careeroffice.dao.pivot.KeywordClassifiedPivotDao;
import com.careeroffice.dao.KeywordDao;
import com.careeroffice.dao.factory.DaoEnum;
import com.careeroffice.dao.factory.DaoFactory;
import com.careeroffice.model.Keyword;

import java.util.List;
import java.util.stream.Collectors;

public class KeywordService implements IPersistenceService<Keyword> {

    KeywordDao keywordDao = (KeywordDao) DaoFactory.getDao( DaoEnum.KeywordDao );

    public Keyword findOne(int id) {
        return keywordDao.findOne(id);
    }

    public List<Keyword> findAll() {
        return keywordDao.findAll();
    }

    public void save(String title, String slug) {
        Keyword newKeyword = new Keyword(title, slug);
        keywordDao.save(newKeyword);
    }

    public Keyword saveReturn(String title, String slug) {
        Keyword newKeyword = new Keyword(title, slug);
        return keywordDao.save(newKeyword);
    }

    public Keyword findKeywordByTitle(String title) {
        return keywordDao.findKeywordByTitle(title);
    }

}