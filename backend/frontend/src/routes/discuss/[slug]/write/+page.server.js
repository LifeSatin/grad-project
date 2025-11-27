/** @satisfies {import('./$types').Actions} */

import { redirect } from '@sveltejs/kit';

export const actions = {
    default: async ({cookies, request, params}) => {
        const formData = await request.formData();
        const token = cookies.get("token");
        formData.append("authorToken", token);
        let today = new Date();
        formData.append("time", today.toLocaleDateString());
        const res = await fetch(`http://3.27.115.22:8080/discuss/write`, {
            method: "POST",
            body: formData,
        });
        const item = await res.json();
        console.log(item);

        if (item.status === 500) {
            return -1;
        }

        if (item.status === 200) {
            redirect(303, `/discuss/${params.slug}/${item.postId}`);
        }
    }
}

export async function load({ params }) {
    console.log(params.slug);

    return { boardId: params.slug };
}