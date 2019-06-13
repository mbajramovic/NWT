import { Person } from './person';

export class Message {
    public id: number;
    public text: string;
    public title: string;
    public sender: Person;
    public recipient: Person;
    public isRead: boolean;
}
