import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Page } from '../interface/page';
import { thamso } from '../interface/thamso';
import { ThamsoService } from '../thamso.service';

@Component({
  selector: 'app-add-thamso',
  templateUrl: './add-thamso.component.html',
  styleUrls: ['./add-thamso.component.css']
})
export class AddThamsoComponent {
  public thamsoList:Page;
  public thamsoData:thamso[];
  public thamSo:thamso;
  searchValue:string="";
  CurrentPage:number=0;
  
  thamso = {
    maThamSo:'',
    tenThamSo : '',
    loaiThamSo:''
    
  }

  constructor(private thamsoService:ThamsoService){

  }

  ngOnInit() {
    this.getData();  
  }


  getData(): void {
    const ts = new thamso();
    this.thamsoService.getAllThamSo(ts).subscribe(respone => {
      this.thamsoList = respone;
      this.CurrentPage = respone.number;
    }); 
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

}
