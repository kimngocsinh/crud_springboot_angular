import { Component, OnInit, SimpleChanges } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { thamso } from '../interface/thamso';
import { ThamsoService } from '../thamso.service';
import { Page } from '../interface/page'; 
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-list-thamso',
  templateUrl: './list-thamso.component.html',
  styleUrls: ['./list-thamso.component.css']
})
export class ListThamsoComponent implements OnInit{
  public thamsoList:Page;
  public thamsoData:thamso[];
  searchValue:string="";
  CurrentPage:number=0;
  startDate:string;
  endDate:string;
 
  
  constructor(private thamsoService:ThamsoService){}

  ngOnInit() {
    this.getData();  
  }


  getData(): void {
    const ts = new thamso();
    ts.startDate = this.startDate;
    ts.endDate = this.endDate;
    this.thamsoService.getAllThamSo(ts).subscribe(respone => {
      this.thamsoList = respone;
      this.CurrentPage = respone.number;
    }); 
  }

public searchStartDate(value:string){
  this.startDate = value;
  this.checkValue();
}

searchEndDate(value:string){
  this.endDate = value;
  this.checkValue()
}

public checkValue(){
  if(this.startDate != null && this.endDate != null){
    this.getData();
  }
}



public gotoPage(name:string = "", page:number = 0, size:number = 10):void{
  const ts = new thamso();  
  ts.tenThamSo = name;
  ts.page = page;
  ts.size = size;
  ts.startDate = this.startDate;
  ts.endDate = this.endDate;
  this.thamsoService.getAllThamSo(ts).subscribe(respone => {
    this.thamsoList = respone;
    this.CurrentPage = respone.number;
  })
}



public handleNext(name:string = "", page:number = 0, size:number = 10):void{
  const ts = new thamso();
  ts.tenThamSo = name;
  ts.page = page;
  ts.size = size;
  this.thamsoService.getAllThamSo(ts).subscribe(respone => {
    this.thamsoList = respone;
    this.CurrentPage = respone.number;
  })
}




public addThamSo(addForm:NgForm):void{
  this.thamsoService.addThamSo(addForm.value).subscribe((respone:thamso) => {

    this.getData();
    console.log(respone);
  }),
  (error:HttpErrorResponse)=>{
    alert(error.message);
  }
}

public updateThamSo(editForm:NgForm,id:number):void{
  this.thamsoService.updateThamSo(editForm.value,id).subscribe((response:thamso)=>{

    this.getData();
    console.log(response);
  }),
  (error:HttpErrorResponse)=>{
    alert(error.message);
  }

}
public DeleteThamSo(id:any):void{
  this.thamsoService.deleteThamSo(id).subscribe(
    (response:void)=>{
      this.getData();
    },
    (error:HttpErrorResponse)=>{
      alert(error.message);
    }

  )
}


}


