import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-multiplats-view',
  templateUrl: './multiplats-view.component.html',
  styleUrls: ['./multiplats-view.component.css']
})
export class MultiplatsViewComponent implements OnInit {

  form: FormGroup = new FormGroup({
    cityName: new FormControl(''),
    schoolName: new FormControl(''),
    gradeName: new FormControl(''),
    numberOfStudents: new FormControl(''),
  });
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  constructor(private fb: FormBuilder,) { 
    this.form = this.fb.group({
      cityName: ['', Validators.required],
      schoolName: ['', Validators.required],
      gradeName: ['', Validators.required],
      numberOfStudents: ['', Validators.required],
    });
  }

  multiPlatsDTO: any = {
    city: {
      cityId: null,
      cityName: null
    },
    school: {
      city: null,
      schoolId : null,
      schoolName: null
    },
    grade: {
      school: null,
      gradeId: null,
      gradeName: null,
      numberOfStudents: null
    }
  };

  ngOnInit() {
  }

}
