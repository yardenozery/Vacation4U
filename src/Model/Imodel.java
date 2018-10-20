package Model;

public interface Imodel {
    void CreateDB();
    void CreateNewUser(String username,String password,String dateOfBirth,String firstName,String lastName,String city);
    String[] ReadUser(String usr);
    void UpdateUser();
    void DeleteUser();

}
