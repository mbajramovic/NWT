import { Person } from './person';
import { Location } from './Location';

export class Apartment {
    public id: number;
    public description: string;
    public title: string;
    public person: Person;
    public location: Location;
    public image: string;

    constructor(
        id: number,
        description: string,
        title: string,
        person: Person,
        location: Location,
        image: string
    ){

        this.id = id;
        this.description = description;
        this.title = title;
        this.person = person;
        this.location = location;
        this.image = image;
    }
}
