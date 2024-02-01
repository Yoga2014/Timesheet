import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-assets',
  templateUrl: './assets.component.html',
  styleUrls: ['./assets.component.css'],
})
export class AssetsComponent implements OnInit {
  employees: any[] = [];
  selectedEmployee: any = {};
  selectedEmployeeImage: any = '';
  assetDetails: any[] = [];
  receivedAssests: boolean = false;
  assestsData: any;
  selectedFiles?:any;
  progressInfos: any[] = [];
  message: string[] = [];
  previews: string[] = [];

  constructor(
    private employeeService: EmployeeService,
    private formBuilder: FormBuilder
  ) {
    this.assestsData = this.formBuilder.group({
      Id: ['', Validators.required],
      name: ['', Validators.required],
      position: ['', Validators.required],
      number: ['', Validators.required],
      model: [''],
      models: [''],
      assetsname: [''],
      receiveddate: [''],
      returnDate: [''],
      check: [''],
      image: [''],
    });
  }


  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe((res: any) => {
      this.assetDetails = res;

      console.log('Fetched assets:', res);
    });
  }
  selectEmployee(employee: any): void {
    debugger
    this.selectedEmployee = employee; 

    console.log('Selected employee:', employee);
  }

  selectFiles(file: any): void {

    this.message = [];
    this.progressInfos = [];
    this.selectedFiles = Array.from(file.target.files)

    
  }
  
  save() {
    if (this.assestsData.valid) {
      const formData:any[] = this.assestsData.value;

      this.employeeService.addEmployee(formData).subscribe(
        (res: any) => {
          console.log('Successfully added employee:', res);


          this.assestsData.reset();
        },
        (error: any) => {
          console.error('Error adding employee:', error);
        }
      );
    } else {
      console.log('Form is not valid. Please fill in all required fields.');
    }
  }


  

   
}
