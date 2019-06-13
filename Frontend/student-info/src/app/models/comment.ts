import { Person } from './person';
import { Experience } from './experience';

export class Comment {
    public id : number;
    public text : String;
    public postDate : Date;
    public user : Person;
    public experience : Experience;
}