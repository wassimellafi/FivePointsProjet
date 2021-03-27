import { Injectable } from "@angular/core";
import {
  NbComponentStatus,
  NbGlobalPhysicalPosition,
  NbGlobalPosition,
  NbToastrService,
} from "@nebular/theme";
import { HttpClient, HttpHeaders, HttpRequest } from "@angular/common/http";
import { Observable } from "rxjs";
import { DatePipe } from "@angular/common";

@Injectable({
  providedIn: "root",
})
export class UtilsService {

  public static REMOTE_ADDRESS = "http://localhost:8081/";
  public static API_SUBJECT=UtilsService.REMOTE_ADDRESS + "sujet";
  public static API_AUTH_LOGIN = UtilsService.REMOTE_ADDRESS + "auth/signin";
  public static API_AUTH_REGISTER = UtilsService.REMOTE_ADDRESS + "auth/signup";
  public static API_VOTE=UtilsService.REMOTE_ADDRESS + "vote";

  constructor(
    private toastrService: NbToastrService,
    private httpClient: HttpClient,
    private datePipe: DatePipe
  ) {

  }

  public showToast(type: NbComponentStatus, title: string, body: string) {
    const config = {
      status: type,
      destroyByClick: true,
      duration: 4000,
      hasIcon: true,
      position: NbGlobalPhysicalPosition.TOP_RIGHT,
      preventDuplicates: false,
    };
    const titleContent = title ? `${title}` : '';
    this.toastrService.show(
      body,
      `${titleContent}`,
      config);
  }

  public post(url: string, object: any): Observable<any> {

    return this.httpClient.post(url, object);
  }

  public put(url: string, object: any): Observable<any> {

    return this.httpClient.put(url, object);
  }

  public get(url: string): Observable<any> {

    return this.httpClient.get(url);
  }

  public delete(url: string): Observable<any> {

    return this.httpClient.delete(url);
  }



}
