export class Person {
    public id: number;
    public name : string;
    public email : string;
    public username: string;
    public password: string;
    public role: String;

    constructor(
        name : string,
        email : string,
        username: string,
        password: string,
        role: string
    ){
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
