import { Component, OnInit, ViewChild } from '@angular/core';
import { Insurance } from './model/insurance';
import { ImportService } from './services/import.service';
import { HttpService } from './services/http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Project';
  @ViewChild('inputFile') inputFile: any;
  dataPreview: [][];
  dataDatabase: Insurance[];
  data: [][];
  message: string;

  constructor(private importService: ImportService, private httpService: HttpService) {
    this.dataPreview = [];
    this.dataDatabase = [];
    this.data = [];
    this.message = '';
  }

  ngOnInit(): void { }

  readFile(event: any) {
    this.importService.xlsxToJson(event);
    this.importService.getDataPreview().subscribe((json: [][]) => { this.dataPreview = json; })
    this.importService.getData().subscribe((json: [][]) => { this.data = json; })
    this.dataDatabase = [];

  }

  saveData() {
    this.httpService.save(this.data).subscribe();
    this.dataPreview = [];
    this.inputFile.nativeElement.value = '';
    this.message = 'Dane zostały wysłane.';
  }

  getData() {
    this.httpService.get().subscribe((response: Array<Insurance>) => { this.dataDatabase = response });
    this.dataPreview = [];
    this.inputFile.nativeElement.value = '';
  }
  deleteData() {
    this.httpService.delete().subscribe();
    this.dataPreview = [];
    this.dataDatabase = [];
    this.inputFile.nativeElement.value = '';

  }
  hideMessage() {
    this.message = '';
  }



}
