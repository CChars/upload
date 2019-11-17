package com.poi.testpoi.service.Impl;

import com.poi.testpoi.common.MyException;
import com.poi.testpoi.mapper.UserMapper;
import com.poi.testpoi.pojo.Day;
import com.poi.testpoi.pojo.Mate;
import com.poi.testpoi.pojo.Peroid;
import com.poi.testpoi.pojo.User;
import com.poi.testpoi.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sun.security.provider.Sun;

import javax.xml.soap.SAAJResult;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public static  ArrayList<Peroid> avaliables=new ArrayList<>();
    public static ArrayList<Mate> mates=new ArrayList<>();

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> selectUsers() {
        return userMapper.selectUsers();
    }

    /* *
     * @Author QianZ
     * @Description //选出各个时间段的有空的学生
     * @Date 17:51 2019/10/27
     * @Param []
     * @return java.util.List<java.lang.String>
     **/
    @Override
    public List<Day> selectDaysUsers() {
        List<Day> daysUserList = new ArrayList<>();

        //周一有时间的人
        List<User> usersHaveTime_Mon_Moon = new ArrayList<>();
        usersHaveTime_Mon_Moon = userMapper.selectMon_MoonByDays(1);
        List<User> usersHaveTime_Mon_Night = new ArrayList<>();
        usersHaveTime_Mon_Night = userMapper.selectMon_NightByDays(1);

        //周二有时间的人
        List<User> usersHaveTime_Tue_Moon = new ArrayList<>();
        usersHaveTime_Tue_Moon = userMapper.selectTue_MoonByDays(1);
        List<User> usersHaveTime_Tue_Night = new ArrayList<>();
        usersHaveTime_Tue_Night = userMapper.selectTue_NightByDays(1);

        //周三有时间的人
        List<User> usersHaveTime_Wen_Moon = new ArrayList<>();
        usersHaveTime_Wen_Moon = userMapper.selectWen_MoonByDays(1);
        List<User> usersHaveTime_Wen_Night = new ArrayList<>();
        usersHaveTime_Wen_Night = userMapper.selectWen_NightByDays(1);

        //周四有时间的人
        List<User> usersHaveTime_Thu_Night = new ArrayList<>();
        usersHaveTime_Thu_Night = userMapper.selectThu_NightByDays(1);

        //周五有时间的人
        List<User> usersHaveTime_Fri_Moon = new ArrayList<>();
        usersHaveTime_Fri_Moon = userMapper.selectFri_MoonByDays(1);
        List<User> usersHaveTime_Fri_Night = new ArrayList<>();
        usersHaveTime_Fri_Night = userMapper.selectFri_NightByDays(1);

        //周六有时间的人
        List<User> usersHaveTime_Sat_Moon = new ArrayList<>();
        usersHaveTime_Sat_Moon = userMapper.selectSat_MoonByDays(1);
        List<User> usersHaveTime_Sat_Night = new ArrayList<>();
        usersHaveTime_Sat_Night = userMapper.selectSat_NightByDays(1);

        //周日有时间的人
        List<User> usersHaveTime_Sun_Moon = new ArrayList<>();
        usersHaveTime_Sun_Moon = userMapper.selectSun_MoonByDays(1);
        List<User> usersHaveTime_Sun_Night = new ArrayList<>();
        usersHaveTime_Sun_Night = userMapper.selectSun_NightByDays(1);

        //可以收书的
        List<User> userCanBook = userMapper.selectByBook(1);


        ArrayList<String> canBook = new ArrayList<>();
        for (int i = 0; i < userCanBook.size(); i++) {
            canBook.add(userCanBook.get(i).getUsername());
        }

        GetUsers(usersHaveTime_Mon_Moon);
        GetUsers(usersHaveTime_Mon_Night);
        GetUsers(usersHaveTime_Tue_Moon);
        GetUsers(usersHaveTime_Tue_Night);
        GetUsers(usersHaveTime_Wen_Moon);
        GetUsers(usersHaveTime_Wen_Night);
        GetUsers(usersHaveTime_Thu_Night);
        GetUsers(usersHaveTime_Fri_Moon);
        GetUsers(usersHaveTime_Fri_Night);
        GetUsers(usersHaveTime_Sat_Moon);
        GetUsers(usersHaveTime_Sat_Night);
        GetUsers(usersHaveTime_Sun_Moon);
        GetUsers(usersHaveTime_Sun_Night);



        ArrayList<Peroid> results=new ArrayList<>();
        for (Peroid each:avaliables
        ) {
            Collections.sort(each.mates);
            ArrayList<Mate> chosenOnes=new ArrayList<>();

            if(each.mates.size()<=6){
                chosenOnes=new ArrayList<>(each.mates);
                for (int i = 0; i < each.mates.size()-1; i++) {
                    each.mates.get(i).chosenTimes++;
                }
            }
            else{

                for (int i = 0; i < 6; i++) {
                    chosenOnes.add(each.mates.get(i));
                    each.mates.get(i).chosenTimes++;
                }
            }


            results.add(new Peroid(chosenOnes));
        }

//        String Mon_user1 = "+";
//        for (int i = 0; i < 6; i++) {
//            Mon_user1 += results.get(0).mates.get(i).name + "+";
//        }
//        String Mon_user2 = "+";
//        for (int i = 0; i < 6; i++) {
//            Mon_user2 += results.get(1).mates.get(i).name + "+";
//        }
//        String Thu_user1 = "+";
//        for (int i = 0; i < 6; i++) {
//            Thu_user1 += results.get(2).mates.get(i).name + "+";
//        }
//        String Thu_user2 = "+";
//        for (int i = 0; i < 6; i++) {
//            Thu_user2 += results.get(3).mates.get(i).name + "+";
//        }
//        String Wen_user1 = "+";
//        for (int i = 0; i < 6; i++) {
//            Wen_user1 += results.get(4).mates.get(i).name + "+";
//        }
//        String Wen_user2 = "+";
//        for (int i = 0; i < 6; i++) {
//            Wen_user2 += results.get(5).mates.get(i).name + "+";
//        }
//        String Tue_user1 = "+";
//        for (int i = 0; i < 6; i++) {
//            Tue_user1 += results.get(6).mates.get(i).name + "+";
//        }
//        String Fri_user1 = "+";
//        for (int i = 0; i < 6; i++) {
//            Fri_user1 += results.get(7).mates.get(i).name + "+";
//        }
//        String Fri_user2 = "+";
//        for (int i = 0; i < 6; i++) {
//            Fri_user2 += results.get(8).mates.get(i).name + "+";
//        }
//        String Sat_user1 = "+";
//        for (int i = 0; i < 6; i++) {
//            Sat_user1 += results.get(9).mates.get(i).name + "+";
//        }
//        String Sat_user2 = "+";
//        for (int i = 0; i < 6; i++) {
//            Sat_user2 += results.get(10).mates.get(i).name + "+";
//        }
//        String Sun_user1 = "+";
//        for (int i = 0; i < 6; i++) {
//            Sun_user1 += results.get(11).mates.get(i).name + "+";
//        }
//        String Sun_user2 = "+";
//        for (int i = 0; i < 6; i++) {
//            Sun_user2 += results.get(12).mates.get(i).name + "+";
//        }
//
//        Day day  = new Day();
//
//        day.setMon_user(Mon_user1);
//        day.setMon_user2(Mon_user2);
//
//        day.setThu_user(Thu_user1);
//        day.setThu_user2(Thu_user2);
//
//        day.setWen_user(Wen_user1);
//        day.setWen_user2(Wen_user2);
//
//        day.setTue_user(Tue_user1);
//
//        day.setFri_user(Fri_user1);
//        day.setFri_user2(Fri_user2);
//
//        day.setSat_user(Sat_user1);
//        day.setSat_user2(Sat_user2);
//
//        day.setSun_user(Sun_user1);
//        day.setSun_user2(Sun_user2);
//
//        daysUserList.add(day);

//        int a = userMapper.selectUsers().size();
//        String[] name = new String[a];
//        int[] times = new int[a];
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> times = new ArrayList<>();

        for (int i = 0; i < 6; i++) {

            String Mon_user1 = "";
            try{
                Mon_user1 = results.get(0).mates.get(i).name;
                if (!(name.contains(Mon_user1))){
                    name.add(Mon_user1);
                    times.add(results.get(0).mates.get(i).chosenTimes);
                }
            }catch (Exception e){
                Mon_user1 = "";
            }
//            Mon_user1 = results.get(0).mates.get(i).name;
//            if (!(name.contains(Mon_user1))){
//                name.add(Mon_user1);
//                times.add(results.get(0).mates.get(i).chosenTimes);
//            }

            String Mon_user2 = "";
            try {
                Mon_user2 = results.get(1).mates.get(i).name;
                if (!(name.contains(Mon_user2))){
                    name.add(Mon_user2);
                    times.add(results.get(1).mates.get(i).chosenTimes);
                }
            }catch (Exception e){
                Mon_user2 = "";
            }


            String Thu_user1 = "";
            try {
                Thu_user1 = results.get(2).mates.get(i).name;
                if (!(name.contains(Thu_user1))){
                    name.add(Thu_user1);
                    times.add(results.get(2).mates.get(i).chosenTimes);
                }
            }catch (Exception e){
                Thu_user1 = "";
            }
//            Thu_user1 = results.get(2).mates.get(i).name;
//            if (!(name.contains(Thu_user1))){
//                name.add(Thu_user1);
//                times.add(results.get(2).mates.get(i).chosenTimes);
//            }

            String Thu_user2 = "";
            try {
                Thu_user2 = results.get(3).mates.get(i).name;
                if (!(name.contains(Thu_user2))){
                    name.add(Thu_user2);
                    times.add(results.get(3).mates.get(i).chosenTimes);
                }
            }catch (Exception e){
                Thu_user2 = "";
            }
//            Thu_user2 = results.get(3).mates.get(i).name;
//            if (!(name.contains(Thu_user2))){
//                name.add(Thu_user2);
//                times.add(results.get(3).mates.get(i).chosenTimes);
//            }

            String Wen_user1 = "";
            try {
                Wen_user1 = results.get(4).mates.get(i).name;
                if (!(name.contains(Wen_user1))){
                    name.add(Wen_user1);
                    times.add(results.get(4).mates.get(i).chosenTimes);
                }
            }catch (Exception e){
                Wen_user1 = "";
            }


            String Wen_user2 = "";
            try {
                Wen_user2 = results.get(5).mates.get(i).name;
                if (!(name.contains(Wen_user2))){
                    name.add(Wen_user2);
                    times.add(results.get(6).mates.get(i).chosenTimes);
                }
            }catch (Exception e){
                Wen_user2 = "";
            }

            String Tue_user1 = "";
            try {
                Tue_user1 = results.get(6).mates.get(i).name;
                if (!(name.contains(Tue_user1))){
                    name.add(Tue_user1);
                    times.add(results.get(6).mates.get(i).chosenTimes);
                }
            }catch (Exception e){
                Tue_user1 = "";
            }


            String Fri_user1 = "";
            try{
                Fri_user1 = results.get(7).mates.get(i).name;
                if (!(name.contains(Fri_user1))){
                    name.add(Fri_user1);
                    times.add(results.get(7).mates.get(i).chosenTimes);
                }
            }catch (Exception e){
                Fri_user1 = "";
            }


            String Fri_user2 = "";
            try {
                Fri_user2 = results.get(8).mates.get(i).name;
                if (!(name.contains(Fri_user2))){
                    name.add(Fri_user2);
                    times.add(results.get(8).mates.get(i).chosenTimes);
                }
            }catch (Exception e){
                Fri_user2 = "";
            }

            String Sat_user1 = "";
            try{
                Sat_user1 = results.get(9).mates.get(i).name;
                if (!(name.contains(Sat_user1))){
                    name.add(Sat_user1);
                    times.add(results.get(9).mates.get(i).chosenTimes);
                }
            }catch (Exception e){
                Sat_user1 = "";
            }


            String Sat_user2 = "";
            try{
                Sat_user2 = results.get(10).mates.get(i).name;
                if (!(name.contains(Sat_user2))){
                    name.add(Sat_user2);
                    times.add(results.get(10).mates.get(i).chosenTimes);
                }
            }catch (Exception e){
                Sat_user2 = "";
            }

            String Sun_user1 = "";
            try {
                Sun_user1 = results.get(11).mates.get(i).name;
                if (!(name.contains(Sun_user1))){
                    name.add(Sun_user1);
                    times.add(results.get(11).mates.get(i).chosenTimes);
                }
            }catch (Exception e){
                Sun_user1 = "";
            }


            String Sun_user2 = "";
            try{
                Sun_user2 = results.get(12).mates.get(i).name;
                if (!(name.contains(Sun_user2))){
                    name.add(Sun_user2);
                    times.add(results.get(12).mates.get(i).chosenTimes);
                }
            }catch (Exception e){
                Sun_user2 = "";
            }



            Day day  = new Day();
            Boolean a = false;
            day.setMon_user(Mon_user1);
            day.setMon_user2(Mon_user2);
            if (canBook.contains(Mon_user2)) {
                day.setBookMon(true);
            }

            day.setThu_user(Thu_user1);
            day.setThu_user2(Thu_user2);
            if (canBook.contains(Thu_user2)) {
                day.setBookThu(true);
            }

            day.setWen_user(Wen_user1);
            day.setWen_user2(Wen_user2);
            if (canBook.contains(Wen_user2)) {
                day.setBookWen(true);
            }

            day.setTue_user(Tue_user1);
            if (canBook.contains(Tue_user1)) {
                day.setBookTue(true);
            }

            day.setFri_user(Fri_user1);
            day.setFri_user2(Fri_user2);
            if (canBook.contains(Fri_user2)) {
                day.setBookFri(true);
            }

            day.setSat_user(Sat_user1);
            day.setSat_user2(Sat_user2);
            if (canBook.contains(Sat_user2)) {
                day.setBookSat(true);
            }

            day.setSun_user(Sun_user1);
            day.setSun_user2(Sun_user2);
            if (canBook.contains(Sun_user2)) {
                day.setBookSun(true);
            }

            daysUserList.add(day);
        }
        for (int i = 0; i < times.size(); i++) {
            System.out.println(name.get(i) + "的次数" + times.get(i));
        }
        return daysUserList;
    }

    void GetUsers(List<User> time){
        ArrayList<Mate> temp=new ArrayList<>();

        String hh=time.get(0).getUsername();

        for (int i = 0; i < time.size(); i++) {
            boolean exists=false;
            for (Mate each:mates
                 ) {
                if(each.name.equals(time.get(i).getUsername())){
                    exists=true;
                    temp.add(each);
                    break;
                }
            }
            if(exists==false){
                Mate e=new Mate(time.get(i).getUsername());
                mates.add(e);
                temp.add(e);
            }

        }

        avaliables.add(new Peroid(temp));

    }
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws Exception {

        //先删除所有的数据
        userMapper.deleteAllDate();

        boolean notNull = false;
        List<User> userList = new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet != null) {
            notNull = true;
        }
        User user;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {//r = 2 表示从第三行开始循环 如果你的第三行开始是数据
            Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
            if (row == null) {
                continue;
            }

            //sheet.getLastRowNum() 的值是 10，所以Excel表中的数据至少是10条；不然报错 NullPointerException

            user = new User();

            if (row.getCell(6).getCellType() != 1) {//循环时，得到每一行的单元格进行判断
                throw new MyException("导入失败(第" + (r + 1) + "行,用户名请设为文本格式)");
            }
            String username = row.getCell(6).getStringCellValue();//得到每一行第一个单元格的值
            if (username == null || username.isEmpty()) {//判断是否为空
                throw new MyException("导入失败(第" + (r + 1) + "行,用户名未填写)");
            }

//            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
//            String password = row.getCell(1).getStringCellValue();
            row.getCell(7).setCellType(CellType.STRING);
            int mon_moon = Integer.valueOf(row.getCell(7).getStringCellValue());

            row.getCell(8).setCellType(CellType.STRING);
            int mon_night = Integer.valueOf(row.getCell(8).getStringCellValue());

            row.getCell(9).setCellType(CellType.STRING);
            int tue_moon = Integer.valueOf(row.getCell(9).getStringCellValue());

            row.getCell(10).setCellType(CellType.STRING);
            int tue_night = Integer.valueOf(row.getCell(10).getStringCellValue());

            row.getCell(11).setCellType(CellType.STRING);
            int wed_moon = Integer.valueOf(row.getCell(11).getStringCellValue());

            row.getCell(12).setCellType(CellType.STRING);
            int wed_night = Integer.valueOf(row.getCell(12).getStringCellValue());

            row.getCell(13).setCellType(CellType.STRING);
            int thu_moon = Integer.valueOf(row.getCell(13).getStringCellValue());

            row.getCell(14).setCellType(CellType.STRING);
            int fri_moon = Integer.valueOf(row.getCell(14).getStringCellValue());

            row.getCell(15).setCellType(CellType.STRING);
            int fri_night = Integer.valueOf(row.getCell(15).getStringCellValue());

            row.getCell(16).setCellType(CellType.STRING);
            int sat_moon = Integer.valueOf(row.getCell(16).getStringCellValue());

            row.getCell(17).setCellType(CellType.STRING);
            int sat_night = Integer.valueOf(row.getCell(17).getStringCellValue());

            row.getCell(18).setCellType(CellType.STRING);
            int sun_moon = Integer.valueOf(row.getCell(18).getStringCellValue());

            row.getCell(19).setCellType(CellType.STRING);
            int sun_night = Integer.valueOf(row.getCell(19).getStringCellValue());

            row.getCell(20).setCellType(CellType.STRING);
            int book = Integer.valueOf(row.getCell(20).getStringCellValue());

            row.getCell(21).setCellType(CellType.STRING);
            String remarks = row.getCell(21).getStringCellValue();//得到每一行第一个单元格的值
            if (username == null || username.isEmpty()) {//判断是否为空
                remarks = "无";
            }

            //完整的循环一次 就组成了一个对象
            user.setUsername(username);

            user.setMon_moon(mon_moon);
            user.setMon_night(mon_night);

            user.setTue_moon(tue_moon);
            user.setTue_night(tue_night);

            user.setWed_moon(wed_moon);
            user.setWed_night(wed_night);

            user.setThu_moon(thu_moon);

            user.setFri_moon(fri_moon);
            user.setFri_night(fri_night);

            user.setSat_moon(sat_moon);
            user.setSat_night(sat_night);

            user.setSun_moon(sun_moon);
            user.setSun_night(sun_night);

            user.setBook(book);
            user.setRemarks(remarks);

            userList.add(user);
        }
        for (User userResord : userList) {
            String name = userResord.getUsername();
            int cnt = userMapper.selectByName(name);
            if (cnt == 0) {
                userMapper.addUser(userResord);
                System.out.println(" 插入 " + userResord);
            } else {
                userMapper.updateUserByName(userResord);
                System.out.println(" 更新 " + userResord);
            }
        }
        return notNull;
    }

}
