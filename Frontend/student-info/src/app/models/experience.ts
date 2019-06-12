import { Person } from './person';

export class Experience {
    public id : number;
    public title : String;
    public text : String;
    public postDate : Date;
    public user : Person;

    constructor(text, user) {
        this.text = text;
        this.user = user;
        this.postDate = new Date();
        this.title = "My experience...";
    }
}