import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import * as XLSX from 'xlsx';

@Injectable({
  providedIn: 'root'
})
export class ImportService {

  private dataPreview = new Subject<[][]>();
  private data = new Subject<[][]>();

  constructor() { }

  xlsxToJson(event: any) {

    let data: any = null;
    let result = null;

    const fileReader = new FileReader();

    fileReader.onload = (event) => {

      data = XLSX.read(fileReader.result, { type: 'binary' });

      result = data.SheetNames.reduce((inital: any, name: any) => {
        return data.Sheets[name];
      }, {});

      this.dataPreview.next(XLSX.utils.sheet_to_json(result, { header: 1 }));
      this.data.next(XLSX.utils.sheet_to_json(result));

    }
    fileReader.readAsBinaryString(event.target.files[0]);

  }

  getDataPreview(): Observable<[][]> { return this.dataPreview; }
  getData(): Observable<[][]> { return this.data; }

}
