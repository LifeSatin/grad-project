/** @type {import('./$types').PageLoad} */
export async function load({ fetch, params }) {
	const res = await fetch(`http://localhost:8080/question/post?postId=${params.slug}`, {
                    headers: {
                        "Access-Control-Allow-Origin": "http://localhost:8080",
                    }
                });
    const item = await res.json();

    return { item };
}