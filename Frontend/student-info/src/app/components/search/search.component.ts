import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  @Input() searchText: string;
  @Output() changed = new EventEmitter<string>();

  constructor() { }

  ngOnInit() {
  }
  

  onSearchChange(searchValue : string ) { 
    this.changed.emit(searchValue); 
  }

}
