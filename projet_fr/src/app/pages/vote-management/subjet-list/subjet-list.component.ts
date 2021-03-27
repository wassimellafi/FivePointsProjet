import { Component, OnInit } from '@angular/core';
import {UtilsService} from "../../../services/utils.service";

@Component({
  selector: 'ngx-subjet-list',
  templateUrl: './subjet-list.component.html',
  styleUrls: ['./subjet-list.component.scss']
})
export class SubjetListComponent implements OnInit {

  displayAddSubjet=false;
  sujects: any[];
  displayVote=false;
  subjetToVote= {
    'id':'',
  'title': '',
  'description': ''
};

  subjet = {
    'title': '',
    'description': ''
  }

  constructor(private utilsService: UtilsService) {
  }

  ngOnInit(): void {
    this.getAllSujects();

  }

  showAddSubjet(){
    this.displayAddSubjet=true;
  }

  initSubjet(){
    this.subjet = {
      'title': '',
      'description': ''
    }
  }

  getAllSujects() {
    const context = this;
    this.utilsService.get(UtilsService.API_SUBJECT).subscribe(response => {
        context.sujects = response;
      },
      error => {
        this.utilsService.showToast('danger',
          'Erreur interne',
          `Un erreur interne a été produit lors du chargement des sujets`);
      });
  }

  saveSubjet() {
    const context = this;
    this.utilsService.post(UtilsService.API_SUBJECT, this.subjet).subscribe(response => {
        this.utilsService.showToast('success',
          'Sujet ajouté avec succé',
          `La Sujet a été ajouté avec succé`);
        this.getAllSujects();
        this.initSubjet();
        this.displayAddSubjet=false;
      },
      error => {
        this.utilsService.showToast('danger',
          'Erreur interne',
          `Un erreur interne a été produit lors de l'ajout du sujet`);
      });
  }

  getPour(subjet) {
    if(subjet.voteList.length >0 ) {
      let pour = 0;
      subjet.voteList.forEach(vote => {
        if (vote.choice == true) {
          pour += 1;
        }
      })
      return new Intl.NumberFormat('en-us', {minimumFractionDigits: 2}).format(pour / subjet.voteList.length * 100);
    }
    }

  getContre(subjet) {
    if (subjet.voteList.length > 0) {
      let contre = 0;
      subjet.voteList.forEach(vote => {
        if (vote.choice == false) {
          contre += 1;
        }
      })
      return new Intl.NumberFormat('en-us', {minimumFractionDigits: 2}).format(contre / subjet.voteList.length * 100);
    }
  }

  showVote(subjet){
    this.displayVote=true;
    this.subjetToVote=subjet;
  }

  vote(choice){
    let vote={
      'subjet':this.subjetToVote,
      'choice':choice,
    }
    this.utilsService.post(UtilsService.API_VOTE, vote).subscribe(response => {
        this.utilsService.showToast('success',
          'Vote ajouté avec succé',
          `Le Vote a été ajouté avec succé`);
        this.getAllSujects();
        this.initSubjet();
        this.displayVote=false;
      },
      error => {
        this.utilsService.showToast('danger',
          'Erreur interne',
          `Un erreur interne a été produit lors du vote`);
      });
}

}
