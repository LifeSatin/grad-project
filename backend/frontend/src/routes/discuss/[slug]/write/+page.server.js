/** @satisfies {import('./$types').Actions} */

import { redirect } from '@sveltejs/kit';

export const actions = {
    default: async ({cookies, request, params}) => {
        const formData = await request.formData();
        const res = await fetch(`http://localhost:8080/discuss/write`, {
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
            redirect(303, `/discuss/${params.slug}`);
        }
    }
}

export async function load({ params }) {
    console.log(params.slug);

    return { boardId: params.slug };
}