package ClassroomDemo.ChattingGen2;public class Auth {
    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRealname() {
        return realname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Auth(int id, int age, String username, String password, String realname) {
        this.id = id;
        this.age = age;
        this.username = username;
        this.password = password;
        this.realname = realname;
    }

    public Auth(){super();}

    private int id;
    private int age;
    private String username;
    private String password;
    private String realname;
}
