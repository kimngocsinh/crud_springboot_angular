import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from './interface/page';
import { ThamsoService } from './thamso.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo';

  // thamsoList:Page|any;
  // constructor(private thamsoService:ThamsoService){

  }
  // ngOnInit(): void {
  //     this.getData();
  // }

  // getData():void{
  //   this.thamsoService.getAllThamSo().subscribe((respone:Page) => {
  //     this.thamsoList = respone;
  //     console.log(respone);
  //   })
  // }

  // gotoPage(name:String="", page:number = 0):void{
  //   this.thamsoList.getAllThamSo(name, page).subscribe((respone:Page) => {
  //     this.thamsoList = respone;
  //     console.log(respone);
  //   })
  // }

  // handleNext(name:String = "", page:number = 0):void{
  //   this.thamsoService.getAllThamSo(name, page).subscribe((respone:Page) => {
  //     this.thamsoList = respone;
  //     console.log(respone);
  //   })
  // }
  
// }
