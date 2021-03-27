import { NbMenuItem } from '@nebular/theme';
import { icon } from 'leaflet';

export const MENU_ITEMS: NbMenuItem[] = [
  {
    title: 'Acceuil',
    icon: 'home-outline',
    link: '/zen-people-referential/dashboard',
    home: true,
  },
  {
    title: 'Votes',
    icon: 'settings-2-outline',
    children: [
      {
        title: 'Liste des sujets',
        link: '/zen-people-referential/vote/sujet-list',
        icon: 'people-outline',
      },
    ],

  },

];
