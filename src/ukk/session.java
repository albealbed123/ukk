/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukk;

/**
 *
 * @author user
 */
public class session {

//    private static int U_id;
//    private static String U_username;
//
//    public static int getU_id() {
//        return U_id;
//    }
//
//    public static int setU_id(int U_id) {
//        return session.U_id = U_id;
//    }
//
//    public static String getU_username() {
//        return U_username;
//    }
//
//    public static String setU_username(String U_username) {
//        return session.U_username = U_username;
//    }




//    private static String nik;
//    private static String role;
//
//    // ===== NIK =====
//    public static String getNik() {
//        return nik;
//    }
//
//    public static void setNik(String nik) {
//        session.nik = nik;
//    }
//
//    // ===== ROLE =====
//    public static String getRole() {
//        return role;
//    }
//
//    public static void setRole(String role) {
//        session.role = role;
//    }

//public class session {

//    private static String nik;
//    private static String role;
//
//    public static String getNik() {
//        return nik;
//    }
//
//    public static void setNik(String nik) {
//        session.nik = nik;
//    }
//
//    public static String getRole() {
//        return role;
//    }
//
//    public static void setRole(String role) {
//        session.role = role;
 //   }
    


//    private static String nik;
//    private static String role;
//
//    public static String getNik() {
//        return nik;
//    }
//
//    public static void setNik(String nik) {
//        session.nik = nik;
//    }
//
//    public static String getRole() {
//        return role;
//    }
//
//    public static void setRole(String role) {
//        session.role = role;
//    }
//
//    // OPTIONAL: logout
//    public static void clear() {
//        nik = null;
//        role = null;
//    }



    private static String nik;
    private static String role;

    public static String getNik() {
        return nik;
    }

    public static void setNik(String nik) {
        session.nik = nik;   // atau cukup: nik = nik; tapi lebih aman pakai Session.
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        session.role = role;
    }

    // OPTIONAL: logout
    public static void clear() {
        nik = null;
        role = null;
    }
}




