import { API_BASE_URL } from '../util/Constants';

export const StudentAPI = {
  search(query: string) {
    return fetch(`${API_BASE_URL}/student/search?${new URLSearchParams({ q: query })}`).then((response) => response.json());
  },
};
