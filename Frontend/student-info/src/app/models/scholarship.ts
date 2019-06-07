import { Location } from './Location';
import { Person } from './person';

export class Scholarship {
    public text: string;
    public link: string;
    public date: Date;
    public location: Location;
    public user: Person;

    constructor(
        text: string,
        link: string,
        date: Date,
        location: Location,
        user: Person
    ){
        this.text = text;
        this.link = link;
        this.date = date;
        this.location = location;
        this.user = user;
    }
}
