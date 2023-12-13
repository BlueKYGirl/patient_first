import { createStore as _createStore } from 'vuex';
import axios from 'axios';

const NOTIFICATION_TIMEOUT_DURATION = 3001;

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      officeTimeBlocks: [],
      selectedOfficeId: '',
      dayToBeScheduled: '',
      notification: null,
    },
    mutations: {
      SET_NOTIFICATION(state, notification) {
        if (state.notification) {
          this.commit('CLEAR_NOTIFICATION');
        }

        if (typeof notification === 'string') {
          notification = {
            message: notification,
            type: 'error',
            timeout: NOTIFICATION_TIMEOUT_DURATION
          }
        } else {
          notification.type = notification.type || 'error';
          notification.timeout = notification.timeout || NOTIFICATION_TIMEOUT_DURATION;
        }

        state.notification = notification;

        notification.timer = window.setTimeout(() => {
          this.commit('CLEAR_NOTIFICATION');
        }, notification.timeout);
      },
      CLEAR_NOTIFICATION(state) {
        if (state.notification && state.notification.timer) {
          window.clearTimeout(state.notification.timer);
        }
        state.notification = null;
      },
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      SET_OFFICE_TIMEBLOCKS(state, newOfficeTimeBlocks) {
        state.officeTimeBlocks = newOfficeTimeBlocks;
      },
      SET_DAY_TO_BE_SCHEDULED(state, newDayToBeScheduled) {
        state.dayToBeScheduled = newDayToBeScheduled;
      },
      SET_SELECTED_OFFICE_ID(state, newSelectedOfficeId) {
        state.selectedOfficeId = newSelectedOfficeId;
      },
    },
  });
  return store;
}
