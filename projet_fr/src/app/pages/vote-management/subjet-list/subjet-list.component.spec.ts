import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubjetListComponent } from './subjet-list.component';

describe('SubjetListComponent', () => {
  let component: SubjetListComponent;
  let fixture: ComponentFixture<SubjetListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubjetListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubjetListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
