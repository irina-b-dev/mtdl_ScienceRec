package com.example.sciencerec;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import javafx.util.Pair;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class databaseDAO
{
    private static Connection conn;
    private static Statement stmt;

    JSONObject jsonObject = new JSONObject();
    JSONArray array = new JSONArray();

    public databaseDAO()
    {
        try
        {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/database",
                    "root", "andrei");
            stmt = conn.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened: " + e.getMessage());
        }
    }

    public Connection getConnection()
    {
        return this.conn;
    }

    private boolean checkIfUserExists(String email)
    {
        try
        {
            String strSelect = "select * from account where Email=\'"+email+"\'";
            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened: " + e.getMessage());
        }

        return false;
    }

    private boolean checkIfUserExists(String email, String parola)
    {
        try
        {
            String strSelect = "select * from account where Email=\'"+email+"\' and Password=\'"+parola+"\'";
            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened: " + e.getMessage());
        }

        return false;
    }

    public String[] getUserInfo(String email)
    {
        String[] info = new String[7];
        info[0] = "nouser";

        try
        {
            String strSelect = "select * from account where Email=\'"+email+"\'";
            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset.next())
            {
                info[0] = rset.getString(1);
                info[1] = rset.getString(2);
                info[2] = rset.getString(3);
                info[3] = rset.getString(4);
                info[4] = rset.getString(5);
                info[5] = rset.getString(6);
                info[6] = rset.getString(7);
            }
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened: " + e.getMessage());
        }

        return info;
    }

    public String[] getUserDetails(int id)
    {
        String[] details = new String[6];

        try
        {
            String strSelect = "select * from accountdetails where AccountID=\'"+id+"\'";
            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset.next())
            {
                details[0] = rset.getString(1);
                details[1] = rset.getString(2);
                details[2] = rset.getString(3);
                details[3] = rset.getString(4);
                details[4] = rset.getString(5);
                details[5] = rset.getString(6);
            }
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened: " + e.getMessage());
        }

        return details;
    }

    public User connectUser(String email, String parola)
    {
        User user = null;

        if(checkIfUserExists(email, parola))
        {
            String[] info = getUserInfo(email);
            //TODO
            //check if details exist first
            String[] details = getUserDetails(Integer.parseInt(info[0]));

            UserSettings us = new UserSettings();
            us.setDarkMode(Boolean.parseBoolean(details[5]));

            if(!info[0].equals("nouser"))
            {
                switch (info[1]) {
                    //and use different constructors if so
                    case "student":
                        user = new Student(Integer.parseInt(info[0]), userTypes.STUDENT, info[2], details[1], details[2], details[3], details[4], us);
                        break;
                    case "teacher":
                        user = new Teacher(Integer.parseInt(info[0]), userTypes.TEACHER, info[2], details[1], details[2], details[3], details[4], us);
                        break;
                    case "researcher":
                        user = new Researcher(Integer.parseInt(info[0]), userTypes.RESEARCHER, info[2], details[1], details[2], details[3], details[4], us);
                        break;
                }
            }
        }

        return user;
    }

    public boolean createUser(userTypes type, String email, String password)
    {
        if(checkIfUserExists(email))
        {
            return false;
        }
        else
        {
            try
            {
                String utype = "";
                switch (type) {
                    case STUDENT:
                        utype = "student";
                        break;
                    case TEACHER:
                        utype = "teacher";
                        break;
                    case RESEARCHER:
                        utype = "researcher";
                        break;
                }
                String strInsert = "insert into account(`Type`, `Email`, `Password`) VALUES('" + utype + "', '" + email + "', '" + password + "');";
                PreparedStatement insert = conn.prepareStatement(strInsert);
                insert.execute();

                return true;
            }
            catch(Exception e)
            {
                System.out.println("Oops, something happened(createUser): " + e.getMessage());
            }
        }

        return false;
    }

    public String getPassword(String email)
    {
        try
        {
            String strSelect = "select password from account where Email=\'"+email+"\'";
            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset.next())
            {
                return rset.getString(1);
            }
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened(getPassword): " + e.getMessage());
        }

        return null;
    }

    public boolean checkIfListExists(int listID, int userID)
    {
        try
        {
            String strSelect = "select * from articlelist where ListID=\'"+listID+"\' and userID=\'"+userID+"\';";
            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened: " + e.getMessage());
        }

        return false;
    }

    public boolean checkIfProjectIsInList(int listID, int articleID)
    {
        try
        {
            String strSelect = "select * from articleinlist where ListID=\'"+listID+"\' and ArticleID=\'"+articleID+"\';";
            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened: " + e.getMessage());
        }

        return false;
    }

    public boolean createList(String listName, int userID)
    {
        try
        {
            String strInsert = "insert into articlelist(`ListName`, `userID`) VALUES('" + listName + "', " + userID + ");";
            PreparedStatement insert = conn.prepareStatement(strInsert);
            insert.execute();

            return true;
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened(createList): " + e.getMessage());
        }

        return false;
    }

    public boolean addProjectToList(int listID, int articleID, int userID)
    {
        try
        {
            if(!checkIfListExists(listID, userID))
            {
               return false;
            }
            if(!checkIfProjectIsInList(listID, articleID))
            {
                return false;
            }
            String strInsert = "insert into articleinlist(`ListID`, `ArticleID`) VALUES('" + listID + "', '" + articleID + "');";
            PreparedStatement insert = conn.prepareStatement(strInsert);
            insert.execute();

            return true;
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened: " + e.getMessage());
        }

        return false;
    }

    public Article removeProjectFromList(int listID, int articleID, int userID)
    {
        try
        {
            if(checkIfListExists(listID, userID) && checkIfProjectIsInList(listID, articleID))
            {
                Article a = null;

                String strSelect = "select * from articleinlist where ListID=\'"+listID+"\' and ArticleID=\'"+articleID+"\';";
                ResultSet rset = stmt.executeQuery(strSelect);

                if(rset.next())
                {
                    //fetch it
                    articleTypes t = articleTypes.LICENCE;
                    switch(rset.getString(5))
                    {
                        case "master":
                            t = articleTypes.MASTER;
                            break;
                        case "doctorate":
                            t = articleTypes.DOCTORATE;
                            break;
                        case "national":
                            t = articleTypes.NATIONAL_RESEARCH;
                            break;
                        case "internationa":
                            t = articleTypes.INTERNATIONAL_RESEARCH;
                            break;
                    }
                    a = new Article(Integer.parseInt(rset.getString(1)), rset.getString(2), rset.getString(3).split(" "),
                            rset.getString(4).split(" "), t, rset.getString(6).split(" "), rset.getString(7));
                }

                //delete it
                String strInsert = "delete from articleinlist where ListID="+listID+" and ArticleID="+articleID+";";
                PreparedStatement insert = conn.prepareStatement(strInsert);
                insert.execute();

                //return it

                return a;
            }
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened: " + e.getMessage());
        }

        return null;
    }

    public boolean checkIfArticleExists(String title)
    {
        try
        {
            String strSelect = "select * from articles where Title=\'"+title+"\';";
            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened: " + e.getMessage());
        }

        return false;
    }

    public boolean checkIfArticleExists(int id)
    {
        try
        {
            String strSelect = "select * from articles where ArticleID=\'"+id+"\';";
            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened: " + e.getMessage());
        }

        return false;
    }

    public boolean createArticle(Article a)
    {
        if(!checkIfArticleExists(a.getTitle()))
        {
            try
            {
                String type = "licence";

                switch(a.getType())
                {
                    case MASTER:
                        type = "master";
                    case DOCTORATE:
                        type = "doctorate";
                    case NATIONAL_RESEARCH:
                        type = "national";
                    case INTERNATIONAL_RESEARCH:
                        type = "international";
                }

                String strInsert = "insert into articles(`Title`, `Authors`, `Categories`, `Type`, `KeyWords`, `FilePath`)" +
                        " VALUES('" + a.getTitle() + "', '" + a.getAuthors().toString() + "', '"+a.getCategories().toString()+"', '"+type+"'" +
                        ", '"+a.getKeywords().toString()+"', '"+a.getFilepath()+"');";
                PreparedStatement insert = conn.prepareStatement(strInsert);
                insert.execute();

                return true;
            }
            catch(Exception e)
            {
                System.out.println("Oops, something happened: " + e.getMessage());
            }
        }

        return false;
    }

    public boolean deleteArticle(int articleID)
    {
        try
        {
            String strInsert = "delete from articles where ArticleID="+articleID+";";
            PreparedStatement insert = conn.prepareStatement(strInsert);
            insert.execute();

            return true;
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened: " + e.getMessage());
        }

        return false;
    }

    public boolean editArticle(int articleID, String title, String[] authors, String[] categories, articleTypes typee, String[] keywords, String filepath)
    {
        if(checkIfArticleExists(articleID))
        {
            try
            {
                String type = "licence";

                switch(typee)
                {
                    case MASTER:
                        type = "master";
                    case DOCTORATE:
                        type = "doctorate";
                    case NATIONAL_RESEARCH:
                        type = "national";
                    case INTERNATIONAL_RESEARCH:
                        type = "international";
                }

                String strUpdate = "update articles set Title='"+title+"', Authors='"+authors.toString()+"', Categories='"+categories.toString()+"', " +
                        "Type='"+type+"', KeyWords='"+keywords.toString()+"', FilePath='"+filepath+"' where ArticleID="+articleID+";";
                PreparedStatement insert = conn.prepareStatement(strUpdate);
                insert.execute();

                return true;
            }
            catch(Exception e)
            {
                System.out.println("Oops, something happened: " + e.getMessage());
            }
        }

        return false;
    }

    public boolean exportStudentListAsExcel()
    {
        String dateprobably = "_somedate";//should be changed
        String path = "student_list" + dateprobably + ".xlsx";

        try
        {
            String strSelect = "select * from account where Type='student';";
            ResultSet rset = stmt.executeQuery(strSelect);

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Reviews");

            writeHeaderLine(sheet);

            writeDataLines(rset, sheet);

            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            return true;
        }
        catch(SQLException e)
        {
            System.out.println("Datababse error:" + e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println("File IO error:" + e.getMessage());
        }

        return false;
    }

    private void writeHeaderLine(XSSFSheet sheet)
    {
        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("ID");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Email");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Password");
    }

    private void writeDataLines(ResultSet rset, XSSFSheet sheet) throws SQLException
    {
        int rowCount = 1;

        while (rset.next())
        {
            int student_id = rset.getInt("AccountID");
            String student_email = rset.getString("Email");
            String student_password = rset.getString("Password");

            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(student_id);

            cell = row.createCell(columnCount++);
            cell.setCellValue(student_email);

            cell = row.createCell(columnCount);
            cell.setCellValue(student_password);
        }
    }

    public ArrayList<Article> searchArticles(String searchy)
    {
        String[] s = searchy.split(" ");
        HashSet<Pair<Article, Integer>> found = new HashSet<>();

        for(String word: s)
        {
            word = word.toLowerCase();
            //check if word appears in title, authors or keywords
            try
            {
                String strSelect = "select * from articles;";
                ResultSet rset = stmt.executeQuery(strSelect);

                while(rset.next())
                {
                    int relevance = 0;
                    articleTypes t = articleTypes.LICENCE;
                    switch(rset.getString(5))
                    {
                        case "master":
                            t = articleTypes.MASTER;
                            break;
                        case "doctorate":
                            t = articleTypes.DOCTORATE;
                            break;
                        case "national":
                            t = articleTypes.NATIONAL_RESEARCH;
                            break;
                        case "internationa":
                            t = articleTypes.INTERNATIONAL_RESEARCH;
                            break;
                    }

                    if(rset.getString(2).toLowerCase().contains(word))
                    {
                        relevance++;
                    }
                    if(rset.getString(3).toLowerCase().contains(word))
                    {
                        relevance++;
                    }
                    if(rset.getString(6).toLowerCase().contains(word))
                    {
                        relevance++;
                    }
                    if(relevance > 0)
                    {
                        found.add(new Pair(new Article(Integer.parseInt(rset.getString(1)), rset.getString(2), rset.getString(3).split(" "),
                                rset.getString(4).split(" "), t, rset.getString(6).split(" "), rset.getString(7)), relevance));
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Oops, something happened: " + e.getMessage());
            }
        }

        ArrayList<Pair<Article, Integer>> f = new ArrayList<>(found);

        Comparator<Pair<Article, Integer>> comparator = new Comparator<Pair<Article, Integer>>()
        {
            public int compare(Pair<Article, Integer> tupleA,
                               Pair<Article, Integer> tupleB)
            {
                return tupleB.getValue().compareTo(tupleA.getValue());
            }
        };

        Collections.sort(f, comparator);
        ArrayList<Article> anotherone = new ArrayList<>();
        for(Pair<Article, Integer> x: f)
        {
            anotherone.add(x.getKey());
        }

        return anotherone;
    }

    public boolean deleteUser(String email)
    {
        try
        {
            String strInsert = "delete from account where Email="+email+";";
            PreparedStatement insert = conn.prepareStatement(strInsert);
            insert.execute();

            return true;
        }
        catch(Exception e)
        {
            System.out.println("Oops, something happened: " + e.getMessage());
        }

        return false;
    }
}
