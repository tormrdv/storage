import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Item } from "../models/item.model";

@Injectable({
    providedIn: 'root'
})
export class ItemService {
    
    private baseURL = "http://localhost:8080/api/v1/item"

    constructor(private http: HttpClient) {}

    getItem(): Observable<Item[]>{
        return this.http.get<Item[]>(`${this.baseURL}/all`)
    }
    
    addItem(item: Item): Observable<Item> {
        return this.http.post<Item>(`${this.baseURL}`, item)
    }
    
    getItemById(id: number): Observable<Item> {
        return this.http.get<Item>(`${this.baseURL}/${id}`)
    }

    deleteItem(id: number): Observable<any> {
        return this.http.delete(`${this.baseURL}/${id}`, {responseType: 'text'})
    }
}