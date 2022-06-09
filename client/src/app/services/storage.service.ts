import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})

export class StorageService {

    private baseURL = "http://localhost:8080/api/v1/storage"
    
}