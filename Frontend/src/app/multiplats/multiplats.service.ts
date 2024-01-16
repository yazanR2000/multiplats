import { Injectable } from '@angular/core';
import { enviroment } from 'src/enviroment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MultiplatsService {

  private baseUrl = enviroment.baseUrl;

  constructor(private http: HttpClient) { }

  public getAllCities(): Observable<any>{
    return this.http.get(`${this.baseUrl}/cities`);
  }
  public findAllSchoolsByCityId(cityId: any): Observable<any>{
    return this.http.get(`${this.baseUrl}/schools/${cityId}`);
  }
  public findAllGradesBySchoolId(schoolId:any):Observable<any>{
    return this.http.get(`${this.baseUrl}/grades/${schoolId}`);
  }
  public findAllStudentsByGradeId(gradeId:any):Observable<any>{
    return this.http.get(`${this.baseUrl}/students/${gradeId}`);
  }
  public saveNewMultiPlats(multiPlatsDTO:any):Observable<any>{
    return this.http.post(`${this.baseUrl}/save`,multiPlatsDTO);
  }
  
  public saveStudents(students:any):Observable<any>{
    return this.http.post(`${this.baseUrl}/students/save`,students);
  }
}
