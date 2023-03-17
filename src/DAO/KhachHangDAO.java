/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachHangDTO;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class KhachHangDAO {
    private MySQLConnect mySQL = new MySQLConnect();
    private ArrayList<KhachHangDTO> dskh = new ArrayList<>();
    private Connection connection = mySQL.getConnection();
    
    
}
