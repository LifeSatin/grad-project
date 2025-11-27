/** @satisfies {import('./$types').Actions} */

import { redirect } from '@sveltejs/kit';
import { preloadData, goto } from '$app/navigation';

export const actions = {
    default: async ({cookies, request}) => {
        const formData = await request.formData();
        const res = await fetch(`http://3.27.115.22:8080/login`, {
            method: "POST",
            body: formData,
        });
        const item = await res.json();

        if (item.status === 500) {
            return -1;
        }

        if (item.status === 200) {
            cookies.set('token', item.token, { path: '/'});
            console.log(cookies.get('token'));
            return redirect("303", "/");
        }
    }
}