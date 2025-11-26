/** @satisfies {import('./$types').Actions} */

import { redirect } from '@sveltejs/kit';

export const actions = {
    default: async ({cookies, request}) => {
        const formData = await request.formData();
        const res = await fetch(`http://localhost:8080/login`, {
            method: "POST",
            headers: {
                "Access-Control-Allow-Origin": "http://localhost:8080",
            },
            body: formData,
        });
        const item = await res.json();

        if (item.status === 500) {
            return -1;
        }

        if (item.status === 200) {
            cookies.set('token', item.token, { path: '/'});
            console.log(cookies.get('token'));
            throw redirect(303, '/question');
        }
    }
}