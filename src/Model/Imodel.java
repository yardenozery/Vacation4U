package Model;

public interface Imodel {
    void CreateNewUser(String username,String password,String dateOfBirth,String firstName,String lastName,String city);
    String[] ReadUser(String usr);
    void UpdateUser(String username,String password,String dateOfBirth,String firstName,String lastName,String city);
    void DeleteUser(String userName);

}