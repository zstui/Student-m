package edu.cuit.service.impl;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Teacher;
import edu.cuit.domain.Uptask;
import edu.cuit.mapper.PubtaskMapper;
import edu.cuit.mapper.TeacherMapper;
import edu.cuit.mapper.UptaskMapper;
import edu.cuit.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private PubtaskMapper pubtaskMapper;

    @Autowired
    private UptaskMapper uptaskMapper;
    @Override
    public Teacher findBytnum(String tnum) {

        return teacherMapper.findBytnum(tnum);
    }

    @Override
    public void updatePubtask(Pubtask pubtask) {
        pubtaskMapper.update(pubtask);
    }

    @Override
    public Pubtask findPubtaskById(Integer id) {
        return pubtaskMapper.findAllById(id);
    }

    @Override
    public void insertPubtask(Pubtask pubtask) {
        pubtaskMapper.insert(pubtask);

    }

    @Override
    public List<Pubtask> FindAllPubtask() {
        return pubtaskMapper.findAll();
    }

    @Override
    public List<Pubtask> FindAllPubtaskByTnum(Integer tid) {
        return pubtaskMapper.findAllByTid(tid);
    }

    @Override
    public void deteletPubtaskById(Integer id) {
        pubtaskMapper.delete(id);
    }

    @Override
    public List<Uptask> FindAlluptaskByPubid(Integer id) {
        return uptaskMapper.findAllByPubid(id);
    }


}