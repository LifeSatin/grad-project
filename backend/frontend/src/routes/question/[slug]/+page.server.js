/** @type {import('./$types').PageLoad} */
export async function load({ fetch, params }) {
	const res = await fetch(`https://3.27.115.22.nip.io:8443/question/post?postId=${params.slug}`, {
                    headers: {
                        "Access-Control-Allow-Origin": "http://backend:8080",
                    }
                });
    const item = await res.json();

    return { item };
}

/** @satisfies {import('./$types').Actions} */
export const actions = {
    default: async ({cookies, request, params}) => {
            const formData = await request.formData();
            const token = cookies.get("token");
            let today = new Date();
            formData.append("time", today.toLocaleDateString());
            formData.append("authorToken", token);
            console.log(formData);
            const res = await fetch(`https://3.27.115.22.nip.io:8443/comments/write`, {
                method: "POST",
                headers: {
                    "Access-Control-Allow-Origin": "http://backend:8080",
                },
                body: formData,
            });
            const item = await res.json();

            if (item.status === 500) {
                return -1;
            }
        }
}