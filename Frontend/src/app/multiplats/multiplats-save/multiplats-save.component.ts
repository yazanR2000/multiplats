import { Component, OnInit } from '@angular/core';
import { MultiplatsService } from '../multiplats.service';

@Component({
  selector: 'app-multiplats-save',
  templateUrl: './multiplats-save.component.html',
  styleUrls: ['./multiplats-save.component.css'],
})
export class MultiplatsSaveComponent implements OnInit {
  constructor(private mpService: MultiplatsService) {}
  selectedData: any = {
    city: null,
    school: null,
    grade: null,
    students: [],
  };
  responseData: any = {
    cities: [],
    schools: [],
    grades: [],
    students: [],
  };
  showStudents: boolean = false;
  newStudents: any[] = [];
  ngOnInit() {
    this.getAllCities();
  }

  //   getAllCities
  // findAllSchoolsByCityId
  // findAllGradesBySchoolId
  // findAllStudentsByGradeId

  public getAllCities() {
    debugger;
    this.mpService.getAllCities().subscribe(
      (data: any[]) => {
        debugger;
        this.responseData.cities = data;
      },
      (err) => {
        debugger;
      }
    );
  }
  public findAllSchoolsByCityId() {
    this.removeData('school');
    this.mpService.findAllSchoolsByCityId(this.selectedData.city).subscribe(
      (data: any[]) => {
        debugger;
        this.responseData.schools = data;
      },
      (err) => {}
    );
  }
  public findAllGradesBySchoolId() {
    this.removeData('grade');
    this.mpService.findAllGradesBySchoolId(this.selectedData.school).subscribe(
      (data: any[]) => {
        this.responseData.grades = data;
      },
      (err) => {}
    );
  }
  public findAllStudentsByGradeId() {
    debugger;
    this.mpService
      .findAllStudentsByGradeId(this.selectedData.grade.gradeId)
      .subscribe(
        (data: any[]) => {
          debugger;
          this.showStudents = true;
          this.responseData.students = data;
          this.fillNewStudentsData();
        },
        (err) => {}
      );
  }
  public save() {
    this.mpService.saveStudents(this.studentsToAdd()).subscribe(
      (response) => {
        alert('Students added successfully!');
        // this.showStudents = !this.showStudents;
        this.findAllStudentsByGradeId();
      },
      (err) => {
        alert('Opps something went wrong');
      }
    );
  }
  private studentsToAdd(): any[] {
    debugger
    let studentsToAdd: any[] = [];
    this.newStudents.forEach((std) => {
      if (std.studentsName != null && std.studentsName != '') studentsToAdd.push(std);
    });
    return studentsToAdd;
  }
  private removeData(key: string) {
    this.selectedData[key] = null;
  }
  private fillNewStudentsData() {
    debugger
    this.newStudents = [];
    let gradeSeats = this.selectedData.grade.numberOfStudents;
    let gradeStudents = this.responseData.students.length;
    for(let i =0; i < (gradeSeats - gradeStudents);i++){
      this.newStudents.push({
        studentId: null,
        studentsName: null,
        grade: this.selectedData.grade,
      });
    }
  }
  public fillStudent(i: number,$event: any){
    this.newStudents[i].studentsName = $event.target.value;
  }
}
