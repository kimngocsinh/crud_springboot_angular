import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Page } from '../interface/page';
import { thamso } from '../interface/thamso';
import { ThamsoService } from '../thamso.service';

@Component({
  selector: 'app-edit-thamso',
  templateUrl: './edit-thamso.component.html',
  styleUrls: ['./edit-thamso.component.css']
})
export class EditThamsoComponent implements OnInit{
    public thamsoList:Page | any;
    public thamsoData:thamso[] = [];
    constructor(private thamsoService:ThamsoService){}
    ngOnInit(): void {
        
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

    // public updateThamSo(editForm:NgForm,id:number):void{
    //   this.thamsoService.updateThamSo(editForm.value,id).subscribe((response:thamso)=>{
    
    //     this.getData();
    //     console.log(response);
    //   }),
    //   (error:HttpErrorResponse)=>{
    //     alert(error.message);
    //   }
    
    // }
}


