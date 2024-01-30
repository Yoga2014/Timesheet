import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { EmployeeDetailComponent } from '../employee-detail/employee-detail.component';
import { MatDialogRef } from '@angular/material/dialog';
import { EmployeeService } from '../employee.service';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-employee-popup',
  templateUrl: './employee-popup.component.html',
  styleUrls: ['./employee-popup.component.css']
})
export class EmployeePopupComponent {
  constructor(public dialogRef: MatDialogRef<EmployeePopupComponent>,private fb: FormBuilder,private employeeService:EmployeeService,private sharedService: SharedService) {}
  editFile: boolean = true;
  removeUpload: boolean = false;
  @ViewChild("employee") elememt!:EmployeeDetailComponent ;
  ngOnInit(): void {
    this.initForm();
  }
  employeeForm!: FormGroup;
  close(): void {
    this.dialogRef.close();
  }
  private initForm(): void {
    this.employeeForm = this.fb.group({
      id: [''],
      name: ['', Validators.required],
      position: ['', Validators.required],
      joiningdate: ['', Validators.required],
      address: this.fb.group({
        street: ['', Validators.required],
        city: ['', Validators.required],
        state: ['', Validators.required],
        zip: ['', Validators.required]
      }),
      photo: [''],
      details: [''],
    });
  }

    onSubmit() {
     
        this.employeeService.postEmployees(this.employeeForm.value).subscribe((res:any) => {
          this.sharedService.setEmployeeData(res); // Set the employee data in the shared service
          this.dialogRef.close();
        });
      
    }
    uploadFile(event:any) {
      let reader = new FileReader(); // HTML5 FileReader API
      let file = event.target.files[0];
      if (event.target.files && event.target.files[0]) {
        reader.readAsDataURL(file);
  
        // When file uploads set it to file formcontrol
        reader.onload = () => {
          //this.imageUrl = reader.result;
          this.employeeForm.patchValue({
            file: reader.result
          });
          this.editFile = false;
          this.removeUpload = true;
        }
        // ChangeDetectorRef since file is loading outside the zone
              
      }
    }
  

}
