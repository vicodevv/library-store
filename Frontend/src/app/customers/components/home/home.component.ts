import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { APIResponse, Book } from 'src/app/models';
import { HttpService } from 'src/app/auth/auth.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  public books: Array<Book> = [];
  
  constructor(
    private httpService: HttpService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private tokenStorage: TokenStorageService
  ) { }

  ngOnInit(): void {
    this.getBooks();
  }

  getBooks() {
    this.httpService.getAllBooks().subscribe((response: any) => {
      this.books = response;
      console.log(response);
    });
  }
}
