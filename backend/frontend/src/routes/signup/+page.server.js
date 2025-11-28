/** @satisfies {import('./$types').Actions} */

import { redirect } from '@sveltejs/kit';

export const actions = {
    default: async ({request}) => {
        const formData = await request.formData();
        const res = await fetch(`https://3.27.115.22:8443/register`, {
            method: "POST",
            body: formData,
        });
        const item = await res.json();

        if (item.status === 500) {
            return -1;
        }

        if (item.status === 200) {
            throw redirect(303, '/question');
        }
    }
}