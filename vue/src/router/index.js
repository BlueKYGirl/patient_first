import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import DoctorsListView from '../views/DoctorsListView.vue';
import OfficeDetailsView from '../views/OfficeDetailsView.vue';
import UpdateAvailabilityView from '../views/UpdateAvailabilityView.vue';
import DocAgendaView from '../views/DocAgendaView.vue';
import AddOfficeView from '../views/AddOfficeView.vue';
import ScheduleAppointmentView from '../views/ScheduleAppointmentView.vue';
import ReviewsView from '../views/ReviewsView.vue';
import DocPortalView from '../views/DocPortalView.vue';
import AdminPortalView from '../views/AdminPortalView.vue';
import MyDoctorView from '../views/MyDoctorsView.vue';

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/doctors",
    name: "doctors",
    component: DoctorsListView,
    meta: {
      requiresAuth: true
    }
  },

  {
    path: "/mydoctors",
    name: "my-doctors",
    component: MyDoctorView,
    meta: {
      requiresAuth: false
    }
  },

  {
    path: "/doctors/:doctorId/offices",
    name: "offices",
    component: OfficeDetailsView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/schedule",
    name: "schedule",
    component: UpdateAvailabilityView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/agenda",
    name: "agenda",
    component: DocAgendaView,
  },  
  {
    path: "/docportal",
    name: "doc-portal",
    component: DocPortalView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/admin",
    name: "admin",
    component: AdminPortalView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/docportal/addoffices",
    name: "add-offices",
    component: AddOfficeView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/docportal/reviews",
    name: "reviews",
    component: ReviewsView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/appointments",
    name: "schedule-appointment",
    component: ScheduleAppointmentView,
    meta: {
      requiresAuth: false
    }
  },
 
];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
