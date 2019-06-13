import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ExperienceService } from 'src/app/services/experience.service';
import { Experience } from 'src/app/models/experience';
import { CommentService } from 'src/app/services/comment.service';
import { Person } from 'src/app/models/person';
import { AuthService } from 'src/app/services/auth.service';
import { Comment } from 'src/app/models/comment';
import { CommandName } from 'protractor';

@Component({
  selector: 'app-experience-view',
  templateUrl: './experience-view.component.html',
  styleUrls: ['./experience-view.component.css']
})
export class ExperienceViewComponent implements OnInit {
  experience : Experience;
  comments : Comment[];
  currentUser : Person;

  commentText : String;

  constructor(private route : ActivatedRoute, private experienceService : ExperienceService, private commentService : CommentService, private authService : AuthService) {
    this.authService.currentUser.subscribe(x => this.currentUser = x);
   }

  ngOnInit() {
    var id = Number.parseInt(this.route.snapshot.paramMap.get('id'));
    this.getExperience(id);
    
  }

  getExperience(id : Number) {
    this.experienceService.get(id).subscribe(res => {
      this.commentService.fetch(res.id).subscribe(_res => {
        this.experience = res;
        this.comments = _res;
        console.log(this.comments);
      });
    });
  }

  save() {
    var comment = new Comment();
    comment.text = this.commentText;
    comment.experience = this.experience;
    comment.user = this.currentUser;
    comment.postDate = new Date();
    this.commentService.save(comment).subscribe(res => {
      console.log(res);
    })
  }

}
